<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Cambiar "Empleado" según convenga:-->
<jsp:useBean id="empleadoSession" type="Beans.Empleado" scope="session" class="Beans.Empleado"/>
<jsp:useBean id="empleadoActual" type="Beans.Empleado" scope="request" class="Beans.Empleado"/>


        <header class="header-area">
          <div class="container">
            <div class="row">
              <div class="col-12">

                <nav class="main-nav">
                  <!-- ***** Logo Start ***** -->
                  <ul class="header-logo-img">
                    <li><a href="#"><img src="<%=request.getContextPath()%>/assets/images/PUCPlogo.png" alt="logo" class = logo-imagen style="width: 120px"></a>
                    </li>
                    <li>
                      <span class="vertical-separator"></span>
                    </li>
                    <li>
                      <img src="<%=request.getContextPath()%>/assets/images/Logo-TELECOM.png" alt="logo" class="logo-imagen" style="width: 235px">

                    </li>
                  </ul>

                  <% if(empleadoSession.getIdEmpleado() == 0) {%>

                  <%} else {%>
                  <ul class="welcome-message text-center">
                    <li>
                      <h5>¡Bienvenid@ <%= empleadoActual.getNombre() + " " + empleadoActual.getApellido() %>!</h5>
                      <h6>Actualmente tu usuario es: <%= empleadoActual.getNombreUsuario() %></h6>
                    </li>
                  </ul>


                  <ul class="nav">

                    <li><a class="<%=request.getParameter("page").equals("viajes")? "active": "" %>" href="<%=request.getContextPath()%>/mainservlet">Lista de viajes</a></li>
                    <li><a href="<%=request.getContextPath()%>/loginServlet?a=logout">Cerrar Sesión</a></li>
                  </ul>
                  <%} %>
                </nav>
              </div>
            </div>
          </div>
        </header>

