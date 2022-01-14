<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
<h1 class="h3 mb-3 font-weight-normal mt-5"><@spring.message "registration"/></h1>
<@l.login "/registration" />
</@c.page>