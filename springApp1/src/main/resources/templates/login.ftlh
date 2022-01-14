<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring>

<@c.page>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">

        <div class="col-lg-10"></div>

        <div class="col-lg-1"><a href="?lang=en" class="dropdown-item">EN</a></div>

        <div class="col-lg-1"><a href="?lang=ru" class="dropdown-item">UA</a></div>
    </nav>
<h1 class="h3 mb-3 font-weight-normal mt-5"><@spring.message "authorise"/></h1>
<@l.login "/login" />
<a href="/registration"><@spring.message "user.registration"/></a>
</@c.page>