@import hexlet.code.utils.Urls.Url
@param Url page

@template.layout.page(content=@'
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Последняя проверка</th>
        <th>Код ответа</th>
    </tr>
    </thead>
    <tbody>
    @for(Url el : page) {
    <tr>
        <th>${el.getId()}</th>
        <th>${el.getName()}</th>
        <th>${el.getCreatedAt()}</th>
        <th>${el.getAnswerCode()}</th>
    </tr>
    </tbody>
</table>
')