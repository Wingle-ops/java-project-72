package gg.jte.generated.ondemand.urls;
public final class JteurlsGenerated {
	public static final String JTE_NAME = "urls/urls.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,2,2,25,25,25,25,25,25,25,25};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <main class=\"flex-grow-1\">\r\n                <div class=\"container-fluid bg-dark p-5\">\r\n                    <div class=\"row\">\r\n                        <div class=\"col-md-10 col-lg-8 mx-auto text-white\">\r\n                            <h1 class=\"display-3 mb-0\">Анализатор страниц</h1>\r\n                            <p class=\"lead\">Бесплатно проверяйте сайты на SEO пригодность</p>\r\n                            <form action=\"/urls\" method=\"post\" class=\"rss-form text-body\">\r\n                                <div class=\"row\">\r\n                                    <div class=\"col\">\r\n                                        <div class=\"form-floating\">\r\n                                            <input id=\"url-input\" type=\"text\" name=\"url\" aria-label=\"url\" class=\"form-control w-100\" placeholder=\"ссылка\" autocomplete=\"off\">\r\n                                        </div>\r\n                                    </div>\r\n                                    <div class=\"col-auto\">\r\n                                        <button type=\"submit\" class=\"h-100 btn btn-lg btn-primary px-sm-5\">Проверить</button>\r\n                                    </div>\r\n                                </div>\r\n                            </form>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n            </main>\r\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
