@template.layout.page(
    content = @`
        <main class="flex-grow-1">
                <div class="container-fluid bg-dark p-5">
                    <div class="row">
                        <div class="col-md-10 col-lg-8 mx-auto text-white">
                            <h1 class="display-3 mb-0">Анализатор страниц</h1>
                            <p class="lead">Бесплатно проверяйте сайты на SEO пригодность</p>
                            <form action="/urls" method="post" class="rss-form text-body">
                                <div class="row">
                                    <div class="col">
                                        <div class="form-floating">
                                            <input id="url-input" type="text" name="url" aria-label="url" class="form-control w-100" placeholder="ссылка" autocomplete="off">
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <button type="submit" class="h-100 btn btn-lg btn-primary px-sm-5">Проверить</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
    `
)