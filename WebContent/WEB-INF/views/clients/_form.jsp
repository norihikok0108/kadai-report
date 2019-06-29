<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="name">登録者名</label>
<c:out value="【　${sessionScope.login_employee.name}　】" />
<br /><br />

<label for="client_date">登録日</label><br />
<input type="date" name="client_date" value="<fmt:formatDate value='${client.client_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="client_name">訪問先企業名</label><br />
<input type="text" name="client_name" value="${client.client_name}" />
<br /><br />

<label for="client_name">訪問先担当者氏名</label><br />
<input type="text" name="partner_name" value="${client.partner_name}" />
<br /><br />

<label for="client_address">訪問先住所</label><br />
<input type="text" name="client_address" value="${client.client_address}" />
<br /><br />

<label for="client_content">商談内容</label><br />
<textarea name="client_content" rows="10" cols="50">${client.client_content}</textarea>
<br /><br />


<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>