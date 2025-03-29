@import hexlet.code.utils.Urls.BuildUrl
@param BuildUrl page

@template.layout.page(content=@'
    <h1>Добро пожаловать на главную страницу!</h1>

    @if(!page.getFlash().isEmpty()) {
        <p>${page.getFlash()}</p>
    }
    @endif

    <form action='/index.jte' method='post'>
        <input type='text' name='name' placeholder='Ссылка' class='form-control mb-3'/>
        <input type='submit' class='btn btn-outline-primary' value='Проверить'/>
    </form>
')