<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8"/>
<head>
    <title>당신만의 타로 카드를 만들어보세용가리</title>
    <link href="<%= request.getContextPath() %>/assets/form-style.css" rel="stylesheet">
</head>
<body>
    <main>
      <section>
        <h1>나만의 타로카드 만들기</h1>
      </section>
      <section>
          <figure>
              <img alt="main-image" src="<%= request.getContextPath()%>/assets/taro.png">
          </figure>
        <form method="post">
            <label for="description">
                설명 입력
            </label>
            <input id="description" type="text" name="description" placeholder="당신에 대한 설명을 적어주세요">
            <button>결과보기</button>
        </form>
      </section>
    </main>

</body>
</html>
