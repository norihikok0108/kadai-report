<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${client != null}">
                <h2>顧客情報　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>顧客名</th>
                            <td><c:out value="${client.client_name}" /></td>
                        </tr>
                        <tr>
                            <th>担当者</th>
                            <td>
                                <pre><c:out value="${client.partner_name}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>顧客住所</th>
                            <td><c:out value="${client.client_address}" /></td>
                        </tr>
                        <tr>
                            <th>商談内容</th>
                            <td>
                                <pre><c:out value="${client.client_content}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${client.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${client.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <c:if test="${sessionScope.login_employee.id == client.employee.id}">
                    <p><a href="<c:url value='/clients/edit?id=${client.id}' />">顧客情報を編集する</a></p>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/clients/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>