<#import "layout/empty.ftlh" as layout>

<@layout.render>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex align-items-center justify-content-center h-100">
            <div class="col-md-8 col-lg-7 col-xl-6">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
                     class="img-fluid" alt="Phone image">
            </div>
            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                <div class="h3 text-center">Войти</div>
                <form action="/auth/login" method="POST">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input type="email" id="email"  name="email" class="form-control form-control-lg"/>
                        <label class="form-label" for="email">Email</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <input type="password" id="password" name="password" class="form-control form-control-lg"/>
                        <label class="form-label" for="password">Пароль</label>
                    </div>

                    <div class="d-flex justify-content-around align-items-center mb-4">
                        <!-- Checkbox -->
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="form1Example3"/>
                            <label class="form-check-label" for="form1Example3"> Запомнить меня </label>
                        </div>
                        <a href="#!">Forgot password?</a>
                    </div>

                    <!-- Submit button -->
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Sign in</button>

                </form>
            </div>
        </div>
    </div>
</section>
</@layout.render>
