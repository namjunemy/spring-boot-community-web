<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Board Form</title>
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<#include "../layout/header.ftl">

<div class="container">
    <div class="page-header">
        <h1>게시글 목록</h1>
    </div>
    <div class="pull-right" style="width: 100px;margin: 10px 0;">
        <a href="/board" class="btn btn-primary btn-block">등록</a>
    </div>
    </br></br></br>

    <div id="mainHide">
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="col-md-1">#</th>
                <th class="col-md-2">서비스 분류</th>
                <th class="col-md-5">제목</th>
                <th class="col-md-2">작성 날짜</th>
                <th class="col-md-2">수정 날짜</th>
            </tr>
            </thead>
            <tbody>
            <#list boardList as board>
                <tr>
                    <td>${board.idx}</td>
                    <td>${board.boardType.value}</td>
                    <td><a href="/board?idx=${board.idx}">${board.title}</a></td>
                    <td>${temporals.format(board.createdDate, 'yyyy-MM-dd HH:mm')}</td>
                    <td>${temporals.format(board.updatedDate, 'yyyy-MM-dd HH:mm')}</td>

                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<#include "../layout/footer.ftl">

</body>
</html>