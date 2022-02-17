<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["js/product.js"]>

    <h2 id="product-type">${product}</h2>
    <div id="products" class="row">
        <#list items as item>
            <div class="card d-inline-block" style="width: 18rem;" id="${item.id}">
                <img class="card-img-top" src="/images/${item.image}" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">${item.name}</h5>
                    <p class="card-text">${item.description}</p>
                    <p class="card-text"><b>Price</b>: ${item.price}$</p>
                    <div>
                        <a href="#" class="addToBasket btn btn-primary"><@spring.message "link.add_to_basket" /></a>
                        <a href="/products/${item.id}/reviews" class="review btn btn-warning"><@spring.message "link.reviews" /></a>
                        <input type="number" class="quantity" name="quantity" value="1">
                    </div>
                </div>
            </div>
        </#list>
    </div>

</@main.renderWith>