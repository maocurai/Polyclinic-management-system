<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://freesvg.org/img/abstract-user-flat-1.png" alt="" width="72" height="72">
        <h2><@spring.message "user.list"/></h2>
    </div>
<table class="table table-striped mt-3">
    <thead>
        <tr>
        <th><@spring.message "login"/></th>
        <th><@spring.message "role"/></th>
        <th><@spring.message "options"/></th>
        </tr>
    </thead>
    <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td><a href="/user/${user.id}" class="btn btn-outline-primary" ><@spring.message "edit"/></a></td>
            </tr>
        </#list>
    </tbody>
</table>
</@c.page>