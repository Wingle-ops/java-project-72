package gg.jte.generated.ondemand.urls;
import hexlet.code.Url.UrlCheck;
import hexlet.code.model.Flash;
import java.util.List;
public final class JteurlsGenerated {
	public static final String JTE_NAME = "urls/urls.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,7,7,9,9,11,11,12,12,12,12,13,13,13,17,17,31,31,33,33,33,34,34,34,35,35,35,36,36,36,39,39,45,45,45,45,45,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<UrlCheck> urls, Flash flash) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n        <main class=\"flex-grow-1\">\r\n            ");
				if (flash.isOn()) {
					jteOutput.writeContent(" {\r\n                <div style=\"background-color: ");
					jteOutput.setContext("div", "style");
					jteOutput.writeUserContent(flash.getStatus());
					jteOutput.setContext("div", null);
					jteOutput.writeContent(" ? '#00FF00' : '#40E0D0'}; color: white; padding: 15px; border-radius: 5px;\">\r\n                    <p class=\"m-0\">");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(flash.getFlash());
					jteOutput.writeContent("</p>\r\n                    <button type=\"button\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n                </div>\r\n            }\r\n            ");
				}
				jteOutput.writeContent("\r\n                    <section>\r\n                <div class=\"container-lg mt-5\">\r\n                    <h1>Сайты</h1>\r\n                    <table class=\"table table-bordered table-hover mt-3\">\r\n                        <thead>\r\n                            <tr>\r\n                                <th>ID</th>\r\n                                <th>Имя</th>\r\n                                <th>Последняя проверка</th>\r\n                                <th>Код ответа</th>\r\n                            </tr>\r\n                        </thead>\r\n                        <tbody>\r\n                            ");
				for (UrlCheck url : urls) {
					jteOutput.writeContent(" {\r\n                                <tr>\r\n                                    <th>");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent("</th>\r\n                                    <th>");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(url.getUrl());
					jteOutput.writeContent("</th>\r\n                                    <th>");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(url.getDateCheck());
					jteOutput.writeContent("</th>\r\n                                    <th>");
					jteOutput.setContext("th", null);
					jteOutput.writeUserContent(url.getCodeAnswer());
					jteOutput.writeContent("</th>\r\n                                </tr>\r\n                            }\r\n                            ");
				}
				jteOutput.writeContent("\r\n                        </tbody>\r\n                    </table>\r\n                </div>\r\n                    </section>\r\n                </main>\r\n    ");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<UrlCheck> urls = (List<UrlCheck>)params.get("urls");
		Flash flash = (Flash)params.get("flash");
		render(jteOutput, jteHtmlInterceptor, urls, flash);
	}
}
