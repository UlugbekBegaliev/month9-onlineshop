<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="${.locale}" dir="${dir}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="_csrf_header" content="${_csrf.parameterName!'csrf'}">
    <meta name="_csrf_token" content="${_csrf.token!'no token'}">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta name="theme-color" content="#563d7c">
    <script src="https://code.jquery.com/jquery-3.5.0.js" integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="crossorigin="anonymous"></script>

    <link href="style.css" rel="stylesheet">

    <title>OnlineShop by Begaliev</title>
</head>
<body>
    <nav class="site-header sticky-top py-1">
        <div class="container d-flex flex-column flex-md-row justify-content-between">
            <a class="py-2" href="/" aria-label="Product">
                <img src="/images/car.png" class="d-block mx-auto" role="img" height="24" width="24" alt="">
            </a>

            <a class="py-2 d-none d-md-inline-block" href="/register"><@spring.message "nav.register" /></a>
            <a class="py-2 d-none d-md-inline-block" href="/login"><@spring.message "nav.login" /></a>
            <a class="py-2 d-none d-md-inline-block" href="/basket"><@spring.message "nav.basket" /></a>
            <a class="py-2 d-none d-md-inline-block" href="/purchase"><@spring.message "nav.purchase" /></a>
            <a class="py-2 d-none d-md-inline-block" href="/profile"><@spring.message "nav.profile" /></a>

            <form class="flex box-128" action="/logout" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <button class="py-2 d-none d-md-inline-block logout-button">
                    <@spring.message "nav.logout" />
                </button>
            </form>
            <form action="" method="get">
                <label for="lang_select">
                    <@spring.message "label.language" />:
                </label>
                <select name="lang" id="lang_select">
                    <option value="en">English</option>
                    <option value="ru">Русский</option>
                </select>
                <button type="submit">
                    <@spring.message "button.language-change.text" />
                </button>
            </form>
        </div>
    </nav>
    <div class="container">
    </div>
    <#list scripts as scriptSource>
        <script src="${scriptSource}"></script>
    </#list>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>