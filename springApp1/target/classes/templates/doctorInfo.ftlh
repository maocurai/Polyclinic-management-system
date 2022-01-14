<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
    <div class="py-5 text-center">
        <h2><@spring.message "personal.info"/></h2>
    </div>

    <#if doctor??>
    <div class="row mb-2">
        <div class="col-md-12">
            <div class="card flex-md-row mb-4 box-shadow h-md-250">
                <div class="card-body d-flex flex-column align-items-start">
                    <table class="table table-striped mt-3">
                        <tbody>
                        <tr><td><@spring.message "name.person"/></td><td>${doctor.fullName}</td></tr>
                        <tr><td><@spring.message "specialisation"/></td><td>${doctor.specializationOfDoctor.name}</td></tr>
                        <tr><td><@spring.message "medical.institution"/></td><td>${doctor.medicalInstitution.name}</td></tr>
                        <tr><td><@spring.message "phone.number"/></td><td>${doctor.personalInformation.phone}</td></tr>
                        <tr><td>Email</td><td>${doctor.personalInformation.email}</td></tr>
                        <tr><td><@spring.message "date.of.birth"/></td><td>${doctor.personalInformation.dateOfBirth}</td></tr>
                        <tr><td><@spring.message "city"/></td><td>${doctor.personalInformation.address.city.name}</td></tr>
                        <tr><td><@spring.message "region"/></td><td>${doctor.personalInformation.address.region.name}</td></tr>
                        <tr><td><@spring.message "street.type"/></td><td>${doctor.personalInformation.address.streetType.name}</td></tr>
                        <tr><td><@spring.message "street.name"/></td><td>${doctor.personalInformation.address.streetName.name}</td></tr>
                        <tr><td><@spring.message "buildings.number"/></td><td>${doctor.personalInformation.address.buildingNumber}</td></tr>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <img class="d-block mx-auto mb-4" src="http://cdn.onlinewebfonts.com/svg/img_491471.png" alt="" width="300" height="300">
            </div>
        </div>
    </div>

        <div class="py-5 text-center">
            <h2><@spring.message "all.patients"/></h2>
        </div>
        <div class="text-center">
            <a href="/patient/add/${doctor.id}" class="btn btn-outline-success w-25"><@spring.message "add"/></a>
            <a href="/patient/find/${doctor.id}" class="btn btn-outline-success w-25">Взяти на облік</a>
        </div>
    <div class="row rounded">
        <div class="col-md-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th><@spring.message "name.person"/></th>
                    <th><@spring.message "options"/></th>
                </tr>
                </thead>
                <tbody>
                <#list patientDoctors as patient>
                    <tr>
                        <div class="row">
                            <td>${patient.fullName}</td>
                            <td><a href="/patient/info/${patient.id}" class="btn btn-outline-info" ><@spring.message "more"/></a></td>
                        </div>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>

        <div class="py-5 text-center">
            <h2><@spring.message "certificates.of.illness"/></h2>
        </div>
        <div class="text-center">
            <a href="/doctor/addCertificateOfIllness/${doctor.id}" class="btn btn-outline-success w-25 mb-5" ><@spring.message "add.certificateOfIllness"/></a>
        </div>

    <#list certificatesOfIllness as certificateOfIllness>
        <div class="row rounded">
            <div class="col-md-12">
                <div class="card flex-md-row mb-4 box-shadow h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <table class="table table-striped mt-3">
                            <tbody>
                            <tr><td><@spring.message "date"/></td><td>${certificateOfIllness.dateOfBirth}</td></tr>
                            <tr><td><@spring.message "medical.institution"/></td>
                                <td><p>${certificateOfIllness.medicalInstitution.name} <br>${certificateOfIllness.medicalInstitution.address.region.name} ${certificateOfIllness.medicalInstitution.address.city.name} ${certificateOfIllness.medicalInstitution.address.streetType.name} ${certificateOfIllness.medicalInstitution.address.streetName.name} ${certificateOfIllness.medicalInstitution.address.buildingNumber}</p>
                                </td></tr>
                            <tr><td><@spring.message "patient"/></td><td>${certificateOfIllness.patient.fullName}</td></tr>
                            <tr><td><@spring.message "disease"/></td><td>${certificateOfIllness.disease.name}</td></tr>
                            <tr><td><@spring.message "disease.type"/></td><td>${certificateOfIllness.disease.diseaseType.name}</td></tr>
                            <tr><td><a href="/doctor/editCertificateOfIllness/${certificateOfIllness.id}" class="btn btn-outline-primary" ><@spring.message "edit"/></a></td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</#if>
</@c.page>