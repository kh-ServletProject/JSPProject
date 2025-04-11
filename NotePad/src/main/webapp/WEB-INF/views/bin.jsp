<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>
    <meta charset="UTF-8" />

    <title>${ member.memberName }님의 휴지통</title>
    <link rel="stylesheet" href="/resources/css/detail.css" />
    <style>
      /* 추가된 버튼 스타일 */
      #allselect,
      #deleteBtn,
      #rollbackBtn,
      #goMemoList {
        margin: 10px;
        padding: 10px 20px;
        background-color: #8b4513;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
      }

      #allselect:hover,
      #deleteBtn:hover,
      #rollbackBtn:hover,
      #goMemoList:hover {
        background-color: #8b4513;
      }

      div {
        margin-bottom: 15px;
      }

      table {
        width: 100%;
        border-collapse: collapse;
        background-color: #fff;
        margin-top: 10px;
      }

      table th,
      table td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
      }

      table thead {
        background-color: #8b4513;
        color: white;
      }
    </style>
  </head>
  <body>
    <div>
      <button type="button" id="allselect">전체선택</button>
    </div>
    <div>
      <table border="1" id="bor1">
        <thead>
          <tr id="bor2">
            <th>선택</th>
            <th>번호</th>
            <th>제목</th>
            <th>생성 날짜</th>
            <th>수정 날짜</th>
          </tr>
        </thead>
        <tbody>
          <form action="/memo/delete" method="post" id="multiBinForm">
            <c:forEach
              var="memo"
              items="${ requestScope.memoList }"
              varStatus="vs"
            >
              <c:if test="${ memo.deleted.toString() == 'y'}">
                <tr>
                  <td>
                    <input
                      type="checkbox"
                      class="checkboxBin"
                      name="memoNo"
                      value="${memo.memoNo}"
                    />
                  </td>
                  <td>${ memo.memoNo }</td>
                  <td>${ memo.memoTitle }</td>
                  <td>${ memo.writeDate }</td>
                  <td>${ memo.updateDate }</td>
                </tr>
              </c:if>
            </c:forEach>
            <button id="deleteBtn" value="deleteBtn" name="action">
              영구삭제
            </button>
            <button id="rollbackBtn" value="rollbackBtn" name="action">
              복구
            </button>
          </form>
          <form action="/memo/rollback" method="post" id="rollbackForm"></form>
        </tbody>
      </table>
    </div>
    
    <div>
      <button type="button" id="goMemoList">목록으로</button>
    </div>

    <script src="/resources/js/detail.js"></script>
    <script src="/resources/js/bin.js"></script>
  </body>
</html>

