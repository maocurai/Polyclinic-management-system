<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://freesvg.org/img/abstract-user-flat-1.png" alt="" width="72" height="72">
        <h2><@spring.message "edit"/> <@spring.message "profile"/></h2>
    </div>
    <form class="needs-validation" action="/user" method="post">
        <div class="mb-3">
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label for="login"><@spring.message "login"/></label>
                    <input class="d-block w-100 h-75" type="text" minlength="3" name="username" placeholder="${userToEdit.username}" value="${userToEdit.username}">
                    <div class="invalid-feedback">
                        Please select a valid login.
                    </div>
                </div>

                <div class="col-md-4 mb-3">
                    <label for="buildings number"><@spring.message "role"/></label>
                    <select class="custom-select d-block w-100 h-75" name="role" required>
                        <#list roles as role>
                            <div>
                                <option value="${role}">${role}</option>
                            </div>
                        </#list>
                    </select>
                    <div class="invalid-feedback">
                        Please provide a valid role.
                    </div>
                </div>
                <div class="col-md-4 pt-4">
                <button type="submit" class="btn btn-success btn-lg w-100"><@spring.message "save"/></button>
                </div>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="hidden" value="${userToEdit.id}" name="userId">
    </form>
</@c.page>

