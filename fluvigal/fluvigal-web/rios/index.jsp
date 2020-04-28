<%@page contentType="text/html; charset=UTF-8" import = "com.fluvigal.connectivity.*, com.fluvigal.model.*, com.fluvigal.util.*"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>fluvigal</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="icon" type="image/vnd.microsoft.icon" href="../ico/favicon.ico">
      <link rel="stylesheet" href="../css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
      <style>
         .row {
         margin-bottom: 15px;
         }
      </style>
   </head>
   <body>
      <%
         try{
            String ideString = request.getParameter("ide");
            Integer ide = null;
            if(ideString!=null){
               ide = Integer.parseInt(ideString);
            }else{
               ide = 14;
            }
            MariaDBConnector.openConnection();
      %>
      <div class="jumbotron text-left" style="margin:0; background-color: white; padding: 0px;">
         <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" id="api" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="float:right; margin-right: 10px; margin-top: 10px">API</button>
            <div class="dropdown-menu" aria-labelledby="api" style="float:right; margin-right: 10px; margin-top: 10px">
               <a class="dropdown-item" href="http://104.198.73.152/api/fluvigal-op">fluvigal-op</a>
               <a class="dropdown-item" href="http://104.198.73.152/api/fluvigal-pr">fluvigal-pr</a>
            </div>
         </div>
         <img src="../img/0_logo.png" width="403.5px" height="150px">
      </div>
      <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="margin-bottom: 20px;">
         <a class="navbar-brand" href="#">Menú</a>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
         <span class="navbar-toggler-icon"></span>
         </button>
         <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
               <li class="nav-item">
                  <a class="nav-link" href="../index.jsp">Estacións</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link active" href="#">Ríos</a>
               </li>
               <li class="nav-item">
                  <a class="nav-link" href="../about/index.html">Sobre fluvigal</a>
               </li>
            </ul>
         </div>
      </nav>
      <div style="margin-right: 100px; margin-left: 100px; margin-top: 20px">
         <h2 style="margin-bottom: 15px; border-bottom: 1px solid gray;">Ríos</h2>
         <div class="row">
            <div class="col-sm-2" style="max-height: 500px; overflow-y: scroll; overflow-x: hidden;">
               <ul class="nav nav-pills flex-column">
                  <%
                     for(Rio r: MariaDBConnector.riosAsList()){
                        if(r.getIdRio()==ide){
                           %>
                           <li class="nav-item" style="display: list-item;">
                              <a class="nav-link active" href="index.jsp?ide=<%out.println(r.getIdRio());%>"><%out.println(r.getNome());%></a>
                           </li>
                        <%
                        }else{
                        %>
                        <li class="nav-item" style="display: list-item;">
                           <a class="nav-link" href="index.jsp?ide=<%out.println(r.getIdRio());%>"><%out.println(r.getNome());%></a>
                        </li>
                        <%
                        }
                     }
                  %>
               </ul>
            </div>
            <div class="col-sm-10">
               <%
                  Rio r = MariaDBConnector.rioQuery(ide);
               %>
               <h3 style="margin-bottom: 20px"><%out.println(r.getNome());%></h3>
               <p>As estacións que controlan o río <%out.println(r.getNome());%> son:</p>
               <%
                  for(Estacion e : MariaDBConnector.estacionsAsList(r)){
               %>
               <div class="jumbotron" style="padding-top: 30px; padding-bottom: 10px;">
                  <div class="row">
                     <div class="col-sm-6">
                        <h4><a href="../index.jsp?ide=<%out.println(e.getIdEstacion());%>"><%out.println(e.getNome());%></a></h4><br>
                        <div class="row">
                           <div class="col-sm-6"><b>Provincia</b></div>
                           <div class="col-sm-6"><%out.println(e.getProvincia().getNome());%></div>
                        </div>
                        <div class="row">
                           <div class="col-sm-6"><b>Concello</b></div>
                           <div class="col-sm-6"><%out.println(e.getConcello());%></div>
                        </div>
                     </div>
                     <div class="col-sm-6">
                        <table class="table table-hover table-responsive">
                              <thead>
                                 <tr>
                                    <th style="vertical-align:middle;width:33%"></th>
                                    <th style="vertical-align:middle;width:33%">Valor</th>
                                    <th style="vertical-align:middle;width:33%">Actualizado a</th>
                                 </tr>
                              </thead>
                              <tbody>
                              <%
                                 for(Medicion m: MariaDBConnector.medicionsAsList(e.getIdEstacion())){
                              %>
                                 <tr>
                                    <td style="vertical-align:middle;width:33%"><%out.println(m.getTipoMedicion().getNome());%></td>
                                    <td style="vertical-align:middle;width:33%"><%out.println(m.getValor()+" "+m.getUnidade());%></td>
                                    <td style="vertical-align:middle;width:33%"><%out.println(Formatter.formatDate(m.getData()));%></td>
                                 </tr>
                              <%
                                 }
                              %>
                              </tbody>
                           </table>
                     </div>
                  </div>
               </div>
               <%
                  }
               %>
            </div>
         </div>
      </div>
      </div>
      </div>
      <div class="jumbotron text-center bg-dark" style="margin-top: 50px; margin-bottom: 0px; color: white; position: fixed; left: 0;
         bottom: 0;
         width: 100%; 
         background-color: white;
         padding: 0px;">
         <p>©2020 Alejandro Buján Pampín - Proxecto DAM Ordinario - IES San Clemente</p>
      </div>
      <%
         MariaDBConnector.closeConnection();
      }catch(Exception ex){
        out.println("Erro: "+ex.getMessage());
        ex.printStackTrace();
      }
      %> 
   </body>
</html>