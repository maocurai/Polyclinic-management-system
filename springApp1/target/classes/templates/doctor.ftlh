<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="http://cdn.onlinewebfonts.com/svg/img_491471.png" alt="" width="72" height="72">
        <h2><@spring.message "doctors"/></h2>
    </div>
    <#if isAdmin>
    <div class="text-center">
        <a href="/doctor/add" class="btn btn-outline-success w-25"><@spring.message "add"/></a>
    </div>
    </#if>

    <form class="needs-validation mt-5" action="/doctor" method="get">
        <div class="mb-3">
            <div class="row">
                <div class="col-md-2">
                    <h5><@spring.message "phone.number"/></h5>
                </div>
                <div class="col-md-6">
                    <div class="input-group col-md-6">
                        <div class="input-group-prepend">
                            <span class="input-group-text">+38</span>
                        </div>
                        <input type="tel" pattern="0[1-9]{1}[0-9]{8}" class="form-control" placeholder="${currPhone?if_exists}" value="${currPhone?if_exists}" name="phone" required>
                        <div class="invalid-feedback">
                            Please provide a valid phone number.
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-primary w-100"><@spring.message "show"/></button>
                </div>
                <div class="col-md-2">
                    <a href="/doctor" class="btn btn-secondary active w-100" aria-pressed="true"><@spring.message "cancel"/></a>
                </div>
            </div>
        </div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
    </form>

    <#if doctors??>
    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <th><@spring.message "name.person"/></th>
            <th><@spring.message "phone.number"/></th>
            <th><@spring.message "specialisation"/></th>
            <th><@spring.message "medical.institution"/></th>
            <th>Email</th>
            <th><@spring.message "date.of.birth"/></th>
            <th colspan="2"><@spring.message "options"/></th>
        </tr>
        </thead>
        <tbody>
        <#list doctors as doctor>
            <tr>
                <div class="row mt-3">
                    <td>${doctor.fullName}</td>
                    <td>${doctor.personalInformation.phone}</td>
                    <td>${doctor.specializationOfDoctor.name}</td>
                    <td>${doctor.medicalInstitution.name}</td>
                    <td>${doctor.personalInformation.email}</td>
                    <td>${doctor.personalInformation.dateOfBirth}</td>
                    <td><a href="/doctor/${doctor.id}" class="btn btn-outline-primary" ><@spring.message "edit"/></a></td>
                    <td><a href="/doctor/info/${doctor.id}" class="btn btn-outline-info" ><@spring.message "more"/></a></td>
                </div>
            </tr>
        </#list>
        </tbody>
    </table>
    </#if>
</@c.page>