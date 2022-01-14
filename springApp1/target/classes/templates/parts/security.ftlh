<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        loggedUserId = user.getId()
        isAdmin = user.isAdmin()
        isUser = user.isUser()
        role = user.getRoleAsString()
    >
<#else>
    <#assign
        name = "unknown"
        isAdmin = false
    >
</#if>