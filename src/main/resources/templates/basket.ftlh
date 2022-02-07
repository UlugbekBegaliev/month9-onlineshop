<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["js/basket.js"]>

    <h1>Корзина</h1>
    <div id="basket"></div>
    <#if basketItems??>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col"><@spring.message "col.name" /></th>
                    <th scope="col"><@spring.message "col.quantity" /></th>
                    <th scope="col"><@spring.message "col.price" /></th>
                </tr>
                </thead>
        <#list basketItems as item>
                <tbody>
                <tr id="${item.id}">
                    <th scope="row">${item?counter}</th>
                    <td>${item.productName}</td>
                    <td>${item.quantity}</td>
                    <td>${item.price}$</td>
                </tr>
                </tbody>
        </#list>
            </table>

    <div>
        <a href="/"><@spring.message "link.back" /></a>
    </div>

</@main.renderWith>