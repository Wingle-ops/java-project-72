@import hexlet.code.Url.UrlCheck
@import hexlet.code.model.Flash
@import java.util.List

@param List<UrlCheck> urls
@param Flash flash

@template.layout.page(
    content = @`
        <main class="flex-grow-1">
            @if(flash.isOn()) {
                <div style="background-color: ${flash.getStatus()} ? '#00FF00' : '#40E0D0'}; color: white; padding: 15px; border-radius: 5px;">
                    <p class="m-0">${flash.getFlash()}</p>
                    <button type="button" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            }
            @endif
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
                            @for(UrlCheck url : urls) {
                                <tr>
                                    <th>${url.getId()}</th>
                                    <th>${url.getUrl()}</th>
                                    <th>${url.getDateCheck()}</th>
                                    <th>${url.getCodeAnswer()}</th>
                                </tr>
                            }
                            @endfor
                        </tbody>
                    </table>
                </div>
                    </section>
                </main>
    `
)