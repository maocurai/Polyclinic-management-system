<#macro navbar>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="col-lg-4 p-3">
        <p class="my-0 mr-md-auto font-weight-normal">
        <a class="navbar-brand" href="/"><@spring.message "polyclinic.management.system"/></a></p></div>


    <div class="col-lg-5"></div>

    <div class="col-lg-1"><a href="?lang=en" class="dropdown-item">EN</a></div>

    <div class="col-lg-1"><a href="?lang=ru" class="dropdown-item">UA</a></div>

    <div class="col-lg-1"><@l.logout /></div>
</nav>
</#macro>