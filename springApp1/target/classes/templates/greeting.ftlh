<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
    <div class="text-center" style="margin-top: 20%;">

    <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">

        <main role="main" class="inner cover">
            <h1 class="cover-heading"><@spring.message "user.greeting"/>
                <#if isAdmin>
                    <@spring.message "admin"/>
                <#else>
                    <@spring.message "user"/>
                </#if>
                 ${name}</h1>
            <p class="lead"><@spring.message "polyclinic.management.system"/> <@spring.message "greeting.text"/></p>
            <p class="lead">
                <a href="/" class="btn btn-lg btn-secondary"><@spring.message "more"/></a>
            </p>
        </main>
    </div>
    </div>
</@c.page>