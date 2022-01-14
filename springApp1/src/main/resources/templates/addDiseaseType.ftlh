<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://freesvg.org/img/abstract-user-flat-1.png" alt="" width="72" height="72">
        <h2><@spring.message "add"/> <@spring.message "profile"/></h2>
    </div>
    <form class="needs-validation" action="/disease/createDiseaseType" method="post">
        <div class="mb-3">
            <div class="row">
                <div class="col-md-4 mb-3">
                    <label><@spring.message "name"/></label>
                    <input class="d-block w-100 h-75" type="text" minlength="3" name="diseaseTypeName" placeholder="${existingDiseaseType?if_exists.name?if_exists}">
                    <div class="invalid-feedback">
                        Please select a valid name.
                    </div>
                    <#if exists??>
                        <div class="row">
                            <label for="phone" style="color: #ff0000;" class="mt-1"><@spring.message "data.already.in.base"/></label>
                        </div>
                    </#if>
                </div>
                <div class="col-md-4 pt-4">
                    <button type="submit" class="btn btn-success btn-lg w-100"><@spring.message "save"/></button>
                </div>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</@c.page>