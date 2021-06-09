<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import="com.darkshan.undanganweb.entity.Undangan" %>
<%@page import="com.darkshan.undanganweb.utils.HibernateUtil" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% List listUndangan = HibernateUtil.getUndanganDao().getAllUndangan(); request.setAttribute("listUndangan", listUndangan); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css" rel="stylesheet" />
  <title>Undangan Web</title>
</head>

<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light" style="padding: 10px 5px 10px 5px;">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
    </div>
  </nav>
  <h1>Hello World!</h1>
  <div class="col-md-8" style="padding:10px 10px 10px 10px;">
    <table class="table table-bordered" id="mytable">
      <thead>
        <tr>
          <th>ID</th>
          <th>Alamat</th>
          <th>Jadwal</th>
          <th>Mengundang</th>
          <th>Pengantin Pria</th>
          <th>Pengantin Wanita</th>
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
           </tr>
       </c:forEach>
      </tbody>
    </table>
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