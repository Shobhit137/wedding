
            <%@page import="com.beans.customer"%>
<ul class="nav flex-column">
              <li class="nav-item">
                    <a class="nav-link active" href="#">
                        <span style="text-align: center">
                      <img src="../${customer.photo}" style="border-radius: 50%; width:64px; height: 64px; border-style: double;border-color:blue;"/><br/>
                    </span>
                  
                </a>
           <li class="nav-item">
             
                <a class="nav-link active" href="#">
                  <span data-feather="home"></span>
                  Dashboard <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                  <a class="nav-link" href="addNews.jsp">
                  <span data-feather="file"></span>
                  Book Event
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="shopping-cart"></span>
                   Update/Modify
                </a>
              </li>
              
              
              <li class="nav-item">
                <a class="nav-link" href="editprofile.jsp">
                  <span data-feather="layers"></span>
                  Update Profile
                </a>
              </li> <li class="nav-item">
                <a class="nav-link" href="updatePassword.jsp">
                  <span data-feather="layers"></span>
                  Change Password
                </a>
              </li>
              
            </ul>

            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Booked section</span>
              <a class="d-flex align-items-center text-muted" href="#">
                <span data-feather="plus-circle"></span>
              </a>
            </h6>
            <ul class="nav flex-column mb-2">
              <li class="nav-item">
                <a class="nav-link" href="pending.jsp">
                  <span data-feather="file-text"></span>
                  Pending Booking
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Rejected News
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Waiting
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Report Chart
                </a>
              </li>
            </ul>
        