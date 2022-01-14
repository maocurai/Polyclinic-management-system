<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://www.freeiconspng.com/thumbs/patient-icon/patient-icon-png-21.png" alt="" width="72" height="72">
        <h2><@spring.message "all.patients"/></h2>
    </div>
    <div class="text-center">
    <a href="/patient/add" class="btn btn-outline-success w-25"><@spring.message "add"/></a>
    </div>

    <form class="needs-validation mt-5" action="/patient" method="get">
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
                    <a href="/patient" class="btn btn-secondary active w-100" aria-pressed="true"><@spring.message "cancel"/></a>
                </div>
            </div>
        </div>
        <input type="hidden" value="${doctor?if_exists.id?if_exists}" name="doctorId">
    </form>

    <#if patients??>
    <table class="table table-striped mt-3">
        <thead>
        <tr>
            <th><@spring.message "name.person"/></th>
            <th><@spring.message "phone.number"/></th>
            <th>Email</th>
            <th><@spring.message "date.of.birth"/></th>
            <th><@spring.message "city"/></th>
            <th><@spring.message "region"/></th>
            <th colspan="3"><@spring.message "address"/></th>
            <th colspan="2"><@spring.message "options"/></th>
        </tr>
        </thead>
        <tbody>
        <#list patients as patient>
            <tr>
                <div class="row mt-3">
                    <td>${patient.fullName}</td>
                    <td>${patient.personalInformation.phone}</td>
                    <td>${patient.personalInformation.email}</td>
                    <td>${patient.personalInformation.dateOfBirth}</td>
                    <td>${patient.personalInformation.address.city.name}</td>
                    <td>${patient.personalInformation.address.region.name}</td>
                    <td>${patient.personalInformation.address.streetType.name}</td>
                    <td>${patient.personalInformation.address.streetName.name}</td>
                    <td>${patient.personalInformation.address.buildingNumber}</td>
                    <#if doctor??>
                        <td><a href="/patient/${doctor.id}/${patient.id}" class="btn btn-outline-info" >Взяти на облік</a></td>
                    <#else>
                        <td><a href="/patient/${patient.id}" class="btn btn-outline-primary" ><@spring.message "edit"/></a></td>
                        <td><a href="/patient/info/${patient.id}" class="btn btn-outline-info" ><@spring.message "more"/></a></td>
                    </#if>
                </div>
            </tr>
        </#list>
        </tbody>
    </table>
    </#if>
</@c.page>