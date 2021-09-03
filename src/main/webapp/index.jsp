<%@page import="java.time.LocalDateTime"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import="com.darkshan.undanganweb.entity.Undangan" %>
<%@page import="com.darkshan.undanganweb.utils.HibernateUtil" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% List<Undangan> listUndangan = HibernateUtil.getUndanganDao().getAllUndangan(); request.setAttribute("listUndangan", listUndangan); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css" rel="stylesheet" />
  <title>Undangan Web</title>
</head>

<body >
    <% boolean isLogin=false;
    
    if(session.getAttribute("isLogin")!=null){
        isLogin=(boolean)session.getAttribute("isLogin");
    }
    %>
  <nav class="navbar navbar-expand-lg navbar-light bg-light" style="padding: 10px 5px 10px 5px;">
    <a class="navbar-brand" href="">Undangan Web</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
          <% if(isLogin){ %>
        <li class="nav-item active">
          <a class="nav-link" href="?halaman=logout">Logout <span class="sr-only">(current)</span></a>
     
        </li>
        <% } %>
    </div>
  </nav>
<div style="padding: 0px 10px 10px 10px">
    
  <% String halaman=" ";
      if( request.getParameter("halaman")!=null &&request.getParameter("halaman").length()>0 ){ %>
  <% halaman=request.getParameter("halaman"); %>
  <%}%><%
 
      if(halaman.equalsIgnoreCase("logout")){
          session.invalidate();
          response.sendRedirect("index.jsp");
      }
      else if(halaman.equalsIgnoreCase("register")){
   if(isLogin){
      response.sendRedirect("index.jsp");
  }else{
     String uname =request.getParameter("username");
  if(uname!=null && uname.length()>0){
      String username=request.getParameter("username");
      String password=request.getParameter("password");
     boolean result= HibernateUtil.getUndanganDao().register(username, password);
      if(result){
        %> 
        <div class="alert alert-success">register  berhasil</div> 
<%
       response.sendRedirect("index.jsp");
      }else{
          %>
<div class="alert alert-danger">register  gagal</div> 
        <%
      }
  }     
  
  %>
 <div style="display: flex;justify-content: center;padding: 10px 10px 10px 10px;">
      <div class="col-sm-5 col-sm-offset-3" >
          
  <div class="panel panel-default">
  <div class="panel-heading"></div>
  <div class="panel-body">
      <form method="POST" action="index.jsp?halaman=register">
          <h1>Register</h1>

  <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="text" name="username" class="form-control" id="exampleInputEmail1"  placeholder="Enter username" required>
   
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password" required>
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
      <div style="padding: 15px 15px 15px 15px"><a href="index.jsp" role="button" class="btn btn-success">ke halaman login</a></div>
  </div>
</div>
</div>
 </div>
 <% } }
else if(!isLogin){
if(request.getParameter("username")!=null&& request.getParameter("username").length()>0){
    String usname=request.getParameter("username");
    String paswd=request.getParameter("password");
    boolean res=HibernateUtil.getUndanganDao().login(usname, paswd);
    if(res){
     %> 
        <div class="alert alert-success">login  berhasil</div> 
<%
     session.setAttribute("isLogin", true);
       response.sendRedirect("index.jsp");
}else{
     %> 
        <div class="alert alert-danger">login  gagal</div> 
<%
}
    
}
%>
<div style="display: flex;justify-content: center;padding: 10px 10px 10px 10px;">
      <div class="col-sm-5 col-sm-offset-3" >
          
  <div class="panel panel-default">
  <div class="panel-heading"></div>
  <div class="panel-body">
      <form method="post">
          <h1>Login</h1>

  <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="text" name="username" class="form-control" id="exampleInputEmail1"  placeholder="Enter username" required>
   
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password" required>
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
      <a href="index.jsp?halaman=register" role="button" class="btn btn-success">ke halaman register</a>
  </div>
</div>
</div>
 </div>
<% 
  %>
      <div class="col-sm-6 col-sm-offset-3">
  <div class="panel panel-default">
   
  </div>
</div>
  <% }else if(halaman.equalsIgnoreCase("login")){ %>
     
 <% }  
     else if(halaman.equalsIgnoreCase("hapus")){
int id_und=Integer.parseInt((request.getParameter("id_undangan")));
  Undangan und=HibernateUtil.getUndanganDao().getUndanganById(id_und);
out.print(und);
 if  (HibernateUtil.getUndanganDao().delete(und)){
           %>
         <div class="alert alert-danger">berhasil menghapus data</div>
    <%
         response.sendRedirect("index.jsp");
     }else{
%>
         <div class="alert alert-danger">gagal menghapus data</div>
    <%
}
}    
  %>
  <%if(halaman.equalsIgnoreCase("add")){ %>
  <form method="POST" action="?halaman=add">
  <div class="form-group">
    <label for="pengantin_pria">Pengantin pria</label>
    <input type="text" class="form-control" id="penganti_pria"  placeholder="masukan nama pengantin pria" name="p_pria" required>
   
  </div>
      <div class="form-group">
    <label for="pengantin_wanita">Pengantin wanita</label>
    <input type="text" class="form-control" id="penganti_wanita"  placeholder="masukan nama pengantin wanita" name="p_wanita" required>
   
  </div>
      <div class="form-group">
    <label for="alamat">alamat</label>
    <input type="text" class="form-control" id="alamat"  placeholder="masukan alamat" name="alamat" required>
   
  </div>
      <div class="form-group">
    <label for="jadwa">jadwal </label>
    <input type="datetime-local" class="form-control" id="jadwa"  placeholder="masukan jadwal" name="jadwal"required>
   
  </div>
 <div class="form-group">
    <label for="mengundang">turut mengundang</label>
    <input type="text" class="form-control" id="alamat"  placeholder="masukan tokoh yang diundang" name="undangan" required>
   
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
  <%
  if(request.getParameter("p_pria")!=null&&request.getParameter("p_pria").length()>0){
//      out.print(request.getParameter("p_pria"));
      String p_pria=request.getParameter("p_pria");
      String p_wanita=request.getParameter("p_wanita");
      String alamat=request.getParameter("alamat");
      String jadwal=request.getParameter("jadwal");
      String undangan=request.getParameter("undangan");
      Undangan ud=new Undangan();
      ud.setAlamat(alamat);
      ud.setMengundang(undangan);
      ud.setP_pria(p_pria);
      ud.setP_wanita(p_wanita);
      ud.setJadwal(LocalDateTime.parse(jadwal));
//      out.print(ud.toString());
     if  (HibernateUtil.getUndanganDao().insert(ud)){
         response.sendRedirect("index.jsp");
     }else{ 
  out.print(ud.toString());
  %>
         <div class="alert alert-danger">gagal memasukan data</div>
    <% }
  }    
  %>
  <% }else if(halaman.equalsIgnoreCase("edit")){ %>
  <form method="POST" action="?halaman=edit&id_undangan=<% out.print(request.getParameter("id_undangan"));%>">
      <% 
          int id_undangan=Integer.parseInt((request.getParameter("id_undangan")));
  Undangan ud=HibernateUtil.getUndanganDao().getUndanganById(id_undangan); %>
  <div class="form-group">
    <label for="pengantin_pria">Pengantin pria</label>
    <input type="text" class="form-control" id="penganti_pria" value="<% out.print(ud.getP_pria()); %>"  placeholder="masukan nama pengantin pria" name="p_pria" required>
   
  </div>
      <div class="form-group">
    <label for="pengantin_wanita">Pengantin wanita</label>
    <input type="text" class="form-control" id="penganti_wanita" value="<% out.print(ud.getP_wanita()); %>"   placeholder="masukan nama pengantin wanita" name="p_wanita" required>
   
  </div>
      <div class="form-group">
    <label for="alamat">alamat</label>
    <input type="text" class="form-control" id="alamat" value="<% out.print(ud.getAlamat()); %>"   placeholder="masukan alamat" name="alamat" required>
   
  </div>
      <div class="form-group">
    <label for="jadwa">jadwal </label>
    <input type="datetime-local" class="form-control" id="jadwa" value="<% out.print(ud.getJadwal()); %>"   placeholder="masukan jadwal" name="jadwal"required>
   
  </div>
 <div class="form-group">
    <label for="mengundang">turut mengundang</label>
    <input type="text" class="form-control" id="alamat" value="<% out.print(ud.getMengundang()); %>"   placeholder="masukan tokoh yang diundang" name="undangan" required>
   
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
  <%
  if(request.getParameter("p_pria")!=null&&request.getParameter("p_pria").length()>0){
//      out.print(request.getParameter("p_pria"));
      String p_pria=request.getParameter("p_pria");
      String p_wanita=request.getParameter("p_wanita");
      String alamat=request.getParameter("alamat");
      String jadwal=request.getParameter("jadwal");
      String undangan=request.getParameter("undangan");
//      Undangan ud=new Undangan();
      ud.setAlamat(alamat);
      ud.setMengundang(undangan);
      ud.setP_pria(p_pria);
      ud.setP_wanita(p_wanita);
      ud.setJadwal(LocalDateTime.parse(jadwal));
//      out.print(ud.toString());
     if  (HibernateUtil.getUndanganDao().update(ud)){
         response.sendRedirect("index.jsp");
     }else{ 
  out.print(ud.toString());
  %>
         <div class="alert alert-danger">gagal mengedit data</div>
    <% }}
 %>
   
  <% }else if(isLogin){ %>
  <a href="?halaman=add" role="button" class="btn btn-primary"> tambah </a>
  <div class="" style="padding:10px 10px 10px 10px;">
    <table class="table table-bordered" id="mytable">
      <thead>
        <tr>
          <th>ID</th>
          <th>Alamat</th>
          <th>Jadwal</th>
          <th>Mengundang</th>
          <th>Pengantin Pria</th>
          <th>Pengantin Wanita</th>
          <th>aksi</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach items="${listUndangan}" var="undangan">
           <tr>
               <td><c:out value="${undangan.id_undangan}"/></td>
               <td><c:out value="${undangan.alamat}"/></td>
               <td><c:out value="${undangan.jadwal}"/></td>
               <td><c:out value="${undangan.mengundang}"/></td>
               <td><c:out value="${undangan.p_pria}"/></td>
               <td><c:out value="${undangan.p_wanita}"/></td>
               <td><a role="button" class="btn btn-success" href="?halaman=edit&id_undangan=${undangan.id_undangan}"> edit </a> | <a role="button" href="?halaman=hapus&id_undangan=${undangan.id_undangan}" class="btn btn-danger"> hapus </a></td>
           </tr>
       </c:forEach>
      </tbody>
    </table>
  </div>
  <% } %>
</div>
</body>
<footer>
  <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
    integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
    integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
    crossorigin="anonymous"></script>
  <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>
  <script>
    $(document).ready(function () {
      $('#mytable').DataTable();
    });
  </script>
</footer>

</html>