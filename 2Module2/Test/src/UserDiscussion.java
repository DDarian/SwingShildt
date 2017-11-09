public class UserDiscussion {
    <%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.util.DLUtil" %>
<%@ page import="ru.enunion.model.MessageFile" %>
<%@ page import="ru.enunion.model.MessageStatus" %>
<%@ page import="ru.enunion.model.UserDiscussion" %>
<%@ page import="ru.enunion.service.MessageLocalServiceUtil" %>
<%@ page import="ru.enunion.service.MessageStatusLocalServiceUtil" %>
<%@ page import="ru.enunion.service.UserDiscussionLocalServiceUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ include file="/jsp/Util/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>



<liferay-ui:error key="discussionMergeIsntAllowed" message="Дискуссия с такой темой и списком участников уже существует." />

<%

    com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog(this.getClass());


    try {
        int startPos=0;
        int endPos=1;

        long discussionId = 0;

        discussionId = ParamUtil.getLong(request, "discussionId");

        UserDiscussion userDiscussion = UserDiscussionLocalServiceUtil.findByUserIdDiscussionId(user.getUserId(), discussionId);

        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(userDiscussion.getDeleteDate() == null ? date.getTime() : userDiscussion.getDeleteDate().getTime());

        List<Message> messageList = MessageLocalServiceUtil.getDiscussionMessagesForUser(discussionId, user.getUserId(), false, sqlDate, startPos, endPos);

        Discussion discussion = DiscussionLocalServiceUtil.getDiscussion(discussionId);

        pageContext.setAttribute("sqlDate", sqlDate);
        pageContext.setAttribute("discussion", discussion);
        pageContext.setAttribute("messageList", messageList);
        pageContext.setAttribute("user", user);
        pageContext.setAttribute("userDiscussion", userDiscussion);

        pageContext.setAttribute("startPos", startPos);
        pageContext.setAttribute("endPos", endPos);

        pageContext.setAttribute("discussionTopic", discussion.getOpeningSentence(user.getUserId()));

        List<Long> participantsIds = new ArrayList<Long>();

        for (User discussionParticipant : discussion.getParticipants()) {
            if(discussionParticipant!=null)
                participantsIds.add(discussionParticipant.getUserId());
        }

        CopyOnWriteArrayList<User> participants = getInterlocutors(discussion.getParticipants(), user);


        pageContext.setAttribute("discussionParticipantsList", participants);
        pageContext.setAttribute("discussionParticipantsIds", participantsIds);
    }
    catch (Exception e) {

        _log.info(e.getClass());
        _log.info(e.getMessage());
    }


%>

<portlet:actionURL name="sendMessage" var="sendMessage"/>

<portlet:actionURL name="modifyDiscussion" var="modifyDiscussion"/>

<portlet:actionURL name="removeSelectedMessages" var="removeSelectedMessages"/>

<portlet:actionURL name="changeSelectedMessagesReadStatus" var="changeSelectedMessagesReadStatus"/>

<portlet:resourceURL var="getPortionOfMessages">
</portlet:resourceURL>

<form action="${modifyDiscussion}" method="post" id="mainDiscussionInfoForm" novalidate> <!--Just a Google chrome 10.08.17 bug-->
    <input type="hidden" name="discussionId" id="discussionId" value="${discussion.discussionId}">

    <c:if test="${userDiscussion.isActive}">
        <button type="submit" class="btn btn-success btn-view">
            <i class="fa fa-pencil" aria-hidden="true"></i>
        </button>
    </c:if>

    <%@ include file="mainDiscussionInfo.jsp"%>
</form>

<c:if test="${userDiscussion.isActive}">
    <form action="${sendMessage}" method="post" data-toggle="validator" role="form" enctype="multipart/form-data">
        <input type="hidden" value="false" name="isNewDiscussion">
        <input type="hidden" value="${discussion.discussionId}" name="discussionId">
        <%@ include file="sendMessage.jsp"%>
        <input type="submit" value="Отправить"  class="btn btn-success">
    </form>
</c:if>

<form action="" method="post" id="discussionMessagesChooserForm">
    <input type="hidden" name="setRead" id="setRead" value="true"/>
    <input type="hidden" name="discussionId" id="discussionIdForMessagesChooser" value="${discussion.discussionId}">

    <button type="button" class="btn btn-primary btn-view" role="button" onclick="toggle('messageId'); return false;"><span class="glyphicon glyphicon-asterisk"></span></button>
    <a href="#" onclick='makeSetRead(true);setActionAndSubmit("${changeSelectedMessagesReadStatus}");return false;' class="btn btn-success btn-view">
        <i class="fa fa-flag"></i>
    </a>
    <a href="#" onclick='makeSetRead(false);setActionAndSubmit("${changeSelectedMessagesReadStatus}");return false;' class="btn btn-danger btn-view">
        <i class="fa fa-flag-o"></i>
    </a>
    <button type="submit" class="btn btn-danger btn-view" role="button" onclick="setActionAndSubmit('${removeSelectedMessages}'); return false;"><span class="glyphicon glyphicon-remove"></span></button>
    <div id="messagesPanel">
        <%@ include file="/jsp/discussionMessagesRepresentation.jsp"%>
    </div>
</form>

    <script defer>
    function makeSetRead(read){

        $('#setRead').val(read);
        $('setRead').value="'"+read+"'";

        window.location='${changeSelectedMessagesReadStatus}';
    }
    function setActionAndSubmit(action){

        $('#discussionMessagesChooserForm').attr('action', action);

        $('#discussionMessagesChooserForm').submit();

    }

    (function($) {
        $(window).load(function() {

            var $anchorClick=$('a[data-parent*="accordion"]');

            $anchorClick.each(function () {
                $(this).on('click', function () {

                    var messageId=$(this).attr('data-parent').substr($(this).attr("data-parent").indexOf("-")+1);

                    if (!($(this).attr('class')=="collapsed")){

                        var $targetElem=$(this);
                        var dataAjax={};
                        dataAjax.setRead=true;
                        dataAjax.messageId=messageId;

                        $.ajax({
                                type: 'post',
                                url: '${changeSelectedMessagesReadStatus}',
                                data: dataAjax,
                                success: function (data) {
                            $targetElem.find( 'strong' ).contents().unwrap();
                            $('#collapse-'+dataAjax.messageId).find( 'strong' ).contents().unwrap();
                        },
                        error: function (xhr, str) {
                            alert('Возникла ошибка: ' + xhr.responseCode);
                        }
                        });
                    }
                })});
            $(document).scroll(function () {

                if (!requestData.lock){
                    console.log("scroll");
                    addDataOnScroll (false, '#messagesPanel', '${renderResponse.encodeURL(getPortionOfMessages.toString())}', requestData);
                }
            });

        });
    })(jQuery);


    var requestData={
            request: 'getMessages',
    discussionId: ${discussion.discussionId},
    sqlDate: '${sqlDate.time}',
    startPos: ${startPos+messageList.size()},
    endPos: ${endPos+messageList.size()},
    userId: ${user.userId},
    lock: false
};



</script>
}
