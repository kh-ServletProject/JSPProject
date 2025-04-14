<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>
    <meta charset="UTF-8" />
    <title>메모 수정</title>
    <link rel="stylesheet" href="/resources/css/detail.css" />
  </head>
  <body>
    <form action="/memo/update" method="post" id="updateForm">
      <div>
        <span
          >제목 : <input type="text" name="title" value="${memo.memoTitle}"
        /></span>
        <br />
      </div>
      <div>
        <textarea
          rows="20"
          cols="70"
          name="content"
          style="resize: none"
          placeholder="내용을 입력하세요"
        >
${memo.memoContent}</textarea
        >
      </div>
      <input type="hidden" name="memoNo" value="${param.memoNo}" />
      <div style="text-align: right">
        <button>수정하기</button>
        <button type="button" id="goMemoList">목록으로</button>
      </div>
    </form>

    <%-- session 범위에 message가 있을 경우 --%>
    <c:if test="${not empty sessionScope.message}">
      <script>
        alert("${message}");
      </script>

      <c:remove var="message" scope="session" />
    </c:if>

    <script src="/resources/js/detail.js"></script>
  </body>
</html>
