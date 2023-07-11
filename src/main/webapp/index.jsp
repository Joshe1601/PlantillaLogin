<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<!-- ***** Header Area Start ***** -->
<jsp:include page="/static/head.jsp"/>
<!-- ***** Header Area End ***** -->

<body>

  <form action="<%=request.getContextPath()%>/loginServlet" method="post" class="form">
    <h2 class="form-title">Inicia Sesión:</h2>
    <div class="container">

      <div class="form-group">
        <input type="text" name="username" id="username" class="form-input" placeholder=" ">
        <label for="username" class="form-label">Usuario:</label>
        <span class="form-line"></span>
      </div>

      <div class="form-group">
        <input type="password" name="password" id="password" class="form-input" placeholder=" ">
        <label for="password" class="form-label">Contraseña:</label>
        <span class="form-line"></span>
      </div>
      <% if (request.getParameter("error") != null) {%>
      <div class="form-group text-danger mb-3">Usuario o contraseña incorrectos</div>
      <% }%>
      <button type="submit" class="form-submit">Ingresar</button>
    </div>
  </form>
<!-- ***** Footer Area Start ***** -->
<jsp:include page="/static/footer.jsp"/>
<!-- ***** Footer Area End ***** -->

</body>
</html>
