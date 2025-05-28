import hexlet.code.Url.UrlCheck;
import hexlet.code.model.Flash

param UrlCheck urls
param Flash flash

@template.layout.page(
    content = @`
        <main class="flex-grow-1">
                    <section>
                <div class="container-lg mt-5">
                    <h1>Сайты</h1>
                    <table class="table table-bordered table-hover mt-3">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Имя</th>
                                <th>Последняя проверка</th>
                                <th>Код ответа</th>
                            </tr>
                        </thead>
                        <tbody>
                            @for() {
                                
                            }
                            @endfor
                        </tbody>
                    </table>
                </div>
                    </section>
                </main>
    `
)