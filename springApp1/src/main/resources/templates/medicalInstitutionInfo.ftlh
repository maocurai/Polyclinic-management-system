<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://cdn-icons-png.flaticon.com/512/88/88977.png" alt="" width="72" height="72">
        <h2>${medicalInstitution.name}</h2>
    </div>
    <h5><@spring.message "address"/></h5>
    <p>${medicalInstitution.address.region.name} ${medicalInstitution.address.city.name} ${medicalInstitution.address.streetType.name} ${medicalInstitution.address.streetName.name} ${medicalInstitution.address.buildingNumber}</p>

    <div class="py-3 text-center">
        <h4 class=""><@spring.message "doctors"/></h4>
    </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th><@spring.message "name"/></th>
                <th><@spring.message "phone.number"/></th>
                <th><@spring.message "specialisation"/></th>
                <th>Email</th>
                <th><@spring.message "date.of.birth"/></th>
<#--                <th><@spring.message "city"/></th>-->
<#--                <th><@spring.message "region"/></th>-->
<#--                <th colspan="3"><@spring.message "address"/></th>-->
                <th colspan="3"><@spring.message "options"/></th>
            </tr>
            </thead>
            <tbody>
            <#list medicalInstitution.doctorSet as doctor>
                <tr>
                    <div class="row mt-3">
                        <td>${doctor.fullName}</td>
                        <td>${doctor.personalInformation.phone}</td>
                        <td>${doctor.specializationOfDoctor.name}</td>
                        <td>${doctor.personalInformation.email}</td>
                        <td>${doctor.personalInformation.dateOfBirth}</td>
<#--                        <td>${doctor.personalInformation.address.city.name}</td>-->
<#--                        <td>${doctor.personalInformation.address.region.name}</td>-->
<#--                        <td>${doctor.personalInformation.address.streetType.name}</td>-->
<#--                        <td>${doctor.personalInformation.address.streetName.name}</td>-->
<#--                        <td>${doctor.personalInformation.address.buildingNumber}</td>-->
                        <td><a href="/doctor/info/${doctor.id}" class="btn btn-outline-info" ><@spring.message "more"/></a></td>
                        <td><a href="/doctor/${doctor.id}" class="btn btn-outline-primary" ><@spring.message "edit"/></a></td>
                        <td><a href="/doctor/addCertificateOfIllness/${doctor.id}" class="btn btn-outline-success" ><@spring.message "add.certificateOfIllness"/></a></td>
                    </div>
                </tr>
            </#list>
            </tbody>
        </table>
    <div class="py-3 text-center">
        <h4 class="mt-3 mb-1"><@spring.message "all.patients"/></h4>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th><@spring.message "name"/></th>
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
                    <td><a href="/patient/${patient.id}" class="btn btn-outline-primary" ><@spring.message "edit"/></a></td>
                    <td><a href="/patient/info/${patient.id}" class="btn btn-outline-info" ><@spring.message "more"/></a></td>
                </div>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>