<#macro logout>
 <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
     <button type="submit" class="btn btn-secondary"><@spring.message "sign.out"/></button>
    </form>
</#macro>

<#macro login path>
  <body class="text-center">
      <form action="${path}" method="post" class="form-signin">
        <div style="display: flex; flex-direction: column; align-items: center;">
        <label for="inputEmail" class="sr-only"><@spring.message "login"/></label>
            <input type="text" name="username" minlength="3" class="form-control mt-1 ${(usernameError??)?string('is-invalid', '')}" placeholder="Username" style="width: 30%;">
               <#if usernameError??>
                   <div class="invalid-feedback">
                          ${usernameError}
                   </div>
               </#if>
            <label for="inputPassword" class="sr-only mt-2"><@spring.message "password"/></label>
            <input type="password" name="password" minlength="3" class="form-control mt-1" placeholder="Password" style="width: 30%;">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">
        <@spring.message "sign.in"/></button>
      </form>
  </body>
</#macro>