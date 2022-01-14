<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://cdn-icons-png.flaticon.com/512/88/88977.png" alt="" width="72" height="72">
        <h2><@spring.message "medical.institutions"/></h2>
    </div>
    <div class="text-center">
        <a href="/medicalInstitution/add" class="btn btn-outline-success w-25"><@spring.message "add"/></a>
    </div>

    <form class="needs-validation mt-5" action="/medicalInstitution" method="get">
        <div class="mb-3">
            <div class="row">
                <div class="col-md-2">
                    <h4><@spring.message "city"/></h4>
                </div>
                <div class="col-md-6">
                        <select class="custom-select d-block w-100 h-100" name="cityId" required>
                            <option value="${currCity?if_exists.id?if_exists}">${currCity?if_exists.name?if_exists}</option>
                            <#list cities as city>
                                <option value="${city.id}">${city.name}</option>
                            </#list>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid city.
                        </div>
                </div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-primary w-100"><@spring.message "show"/></button>
                </div>
                <div class="col-md-2">
                    <a href="/medicalInstitution" class="btn btn-secondary active w-100" aria-pressed="true"><@spring.message "cancel"/></a>
                </div>
            </div>
        </div>
    </form>

    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <th><@spring.message "name"/></th>
            <th><@spring.message "city"/></th>
            <th><@spring.message "region"/></th>
            <th colspan="3"><@spring.message "address"/></th>
            <th colspan="2"><@spring.message "options"/></th>
        </tr>
        </thead>
        <tbody>
        <#list medicalInstitutions as medicalInstitution>
            <tr>
                <div class="row mt-3">
                    <td>${medicalInstitution.name}</td>
                    <td>${medicalInstitution.address.city.name}</td>
                    <td>${medicalInstitution.address.region.name}</td>
                    <td>${medicalInstitution.address.streetType.name}</td>
                    <td>${medicalInstitution.address.streetName.name}</td>
                    <td>${medicalInstitution.address.buildingNumber}</td>
                    <td><a href="/medicalInstitution/${medicalInstitution.id}" class="btn btn-outline-primary" ><@spring.message "edit"/></a></td>
                    <td><a href="/medicalInstitution/info/${medicalInstitution.id}" class="btn btn-outline-info" ><@spring.message "more"/></a></td>
                </div>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>