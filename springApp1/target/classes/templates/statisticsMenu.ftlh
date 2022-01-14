<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>

    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://www.svgimages.com/svg-image/s10/statistics-icon.svg" alt="" width="72" height="72">
        <h2><@spring.message "statistics"/></h2>
        <p class="lead"><@spring.message "statistics.menu.text"/></p>
    </div>

        <div class="card-deck mb-3 text-center">
            <div class="card mb-4 box-shadow">
                <div class="card-header">
                    <h6 class="my-0 font-weight-normal"><@spring.message "info"/></h6>
                </div>
                <div class="card-body">
                    <h2 class="card-title pricing-card-title"><@spring.message "statistics.regions.text"/></h2>
                    <a class="btn btn-primary mt-3 mb-1" href="/statistics/diseaseInRegions" ><@spring.message "show"/></a>
                </div>
            </div>

            <div class="card mb-4 box-shadow">
                <div class="card-header">
                    <h6 class="my-0 font-weight-normal"><@spring.message "info"/></h6>
                </div>
                <div class="card-body">
                    <h2 class="card-title pricing-card-title"><@spring.message "statistics.patients.in.medical.institutions.in.city.text"/></h2>
                    <a class="btn btn-primary mt-3 mb-1" href="/statistics/patientsInMedicalInstitutions" ><@spring.message "show"/></a>
                </div>
            </div>

            <div class="card mb-4 box-shadow">
                <div class="card-header">
                    <h6 class="my-0 font-weight-normal"><@spring.message "info"/></h6>
                </div>
                <div class="card-body">
                    <h2 class="card-title pricing-card-title"><@spring.message "statistics.by.month"/></h2>
                    <a class="btn btn-primary mt-3 mb-1" href="/statistics/certificatesOfIllnessByMonth" ><@spring.message "show"/></a>
                </div>
            </div>
        </div>

</@c.page>