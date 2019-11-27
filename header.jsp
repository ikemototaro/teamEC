<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<header>
	<div class="header">
		<!-- Homeに戻るアクション追加 -->
		<h1 class="HeaderTeamName">
			<a href='<s:url action="HomeAction"/>'>pumpkin</a>
		</h1>
		<ul>
			<!-- カテゴリー選択 & 商品検索 -->
			<s:form action="SearchItemAction">
				<!-- カテゴリー選択 -->
				<s:if
					test='#session.mCategoryDTOList != null && #session.mCategoryDTOList.size() > 0'>
					<li><s:select name="categoryId"
							list="#session.mCategoryDTOList" listValue="categoryName"
							listKey="categoryId" class="cs-div" id="categoryId" /></li>
				</s:if>
				<!-- 商品検索 -->
				<li><s:textfield name="keywords" class="txt-keywords"
						placeholder=" 検索ワード" /></li>
				<li><s:submit value="商品検索" class="headerBtn" /></li>
			</s:form>
			<!-- ヘッダーのメニュー（計5ボタン横並び) -->
			<!-- ログインorログアウトボタン -->
			<s:if test="#session.logined==1">
				<!-- ログアウト -->
				<s:form action="LogoutAction">
					<li><s:submit value="ログアウト" class="headerBtn" /></li>
				</s:form>
			</s:if>
			<s:else>
				<!-- ログイン -->
				<s:form action="GoLoginAction">
					<li><s:submit value="ログイン" class="headerBtn" /></li>
				</s:form>
			</s:else>
			<!-- カートボタン -->
			<s:form action="CartAction">
				<li><s:submit value="カート" class="headerBtn" /></li>
			</s:form>
			<!-- マイページボタン -->
			<s:if test="#session.logined==1">
				<s:form action="MyPageAction">
					<li><s:submit value="マイページ" class="headerBtn" /></li>
				</s:form>
			</s:if>
		</ul>
	</div>
</header>
</html>