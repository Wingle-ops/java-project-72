@import hexlet.code.utils.Urls.Url
@param Url page

@template.layout.page(content=@'
<table>
    <tbody>
    <tr>
        <th>ID</th>
        <th>${page.getId()}</th>
    </tr>
    <tr>
        <th>Имя</th>
        <th>${page.getName()}</th>
    </tr>
    <tr>
        <th>Дата создания</th>
        <th>${page.getCreatedAt()}</th>
    </tr>
    </tbody>
</table>
')