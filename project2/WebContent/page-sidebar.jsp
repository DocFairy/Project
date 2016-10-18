<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>ZUPA - Responsive Website Template / Page with sidebar</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!--[if lt IE 9]>
		<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	<link rel="shortcut icon" href="images/favicon.ico" />
	<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/animate.css" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script src="javascript/pace.min.js"></script>
</head>

<body>
	<header>
		<div class="container hidden-xs logo">
			<a href="index.html"><img class="img-responsive" src="images/logos/logo.png" alt="Logo" />
			</a>
		</div>
		<div class="navbar-wrapper">
			<div class="container">
				<nav class="navbar navbar-static-top">
					<div class="navbar-header">
						<a class="navbar-brand visible-xs" href="index.html"><img class="img-responsive" src="images/logos/logo-xs.png" alt="" />
						</a>
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>

					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-center navbar-nav">
							<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#">Pages</a>
								<ul class="dropdown-menu">
									<li class="dropdown-submenu">
										<a href="index.html">Home</a>
									</li>
									<li class="dropdown-submenu">
										<a data-toggle="dropdown" class="trigger dropdown-toggle" href="#">Pages <span class="pull-right"><i class="fa fa-angle-right"></i></span></a>
										<ul class="dropdown-menu">
											<li><a href="page-simple.html">Simple Page</a>
											</li>
											<li><a href="page-sidebar.html">Right Sidebar</a>
											</li>
											<li><a href="about-us.html">About Us</a>
											</li>
											<li><a href="services.html">Services</a>
											</li>
										</ul>
									</li>
									<li class="dropdown-submenu">
										<a data-toggle="dropdown" class="trigger dropdown-toggle" href="#">Blog <span class="pull-right"><i class="fa fa-angle-right"></i></span></a>
										<ul class="dropdown-menu">
											<li><a href="blog-index.html">Blog no sidebars</a>
											</li>
											<li><a href="blog-left-sidebar.html">Blog left sidebar</a>
											</li>
											<li><a href="blog-right-sidebar.html">Blog right sidebar</a>
											</li>
											<li><a href="blog-post.html">Blog post</a>
											</li>
										</ul>
									</li>
									<li class="dropdown-submenu">
										<a data-toggle="dropdown" class="trigger dropdown-toggle" href="#">Portfolio / Gallery <span class="pull-right"><i class="fa fa-angle-right"></i></span></a>
										<ul class="dropdown-menu">
											<li><a href="portfolio-2-columns.html">2 columns</a>
											</li>
											<li><a href="portfolio-3-columns.html">3 columns</a>
											</li>
											<li><a href="portfolio-4-columns.html">4 columns</a>
											</li>
											<li><a href="portfolio.html">Portfolio with filter</a>
											</li>
											<li><a href="portfolio-item.html">Portfolio item</a>
											</li>
										</ul>
									</li>
									<li class="dropdown-submenu">
										<a data-toggle="dropdown" class="trigger dropdown-toggle" href="#">Special <span class="pull-right"><i class="fa fa-angle-right"></i></span></a>
										<ul class="dropdown-menu">
											<li><a href="404.html">404</a>
											</li>
											<li><a href="empty.html">Empty</a>
											</li>
											<li><a href="login.html">Sign in</a>
											</li>
										</ul>
									</li>

								</ul>
							</li>

							<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#">Features</a>
								<ul class="dropdown-menu">
									<li><a href="typography.html">Typography</a>
									</li>
									<li><a href="forms.html">Forms</a>
									</li>
									<li><a href="buttons.html">Buttons</a>
									</li>
								</ul>
							</li>

							<li><a href="card.html">Menu</a>
							</li>

							<li><a href="contact.html">Contact</a>
							</li>

						</ul>
					</div>
				</nav>
			</div>
		</div>
	</header>

	<div class="container">
		<div class="row">
			<div class="col-sm-8 col-md-9 col-xs-12">
				<article class="content">
					<h1>Page with sidebar</h1>
					<p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum maximus nunc et velit semper, at pellentesque ex semper. Morbi enim massa, porta ut elementum ut, gravida interdum lacus. Etiam enim justo, semper sed scelerisque id, tristique at risus.</p>
					<blockquote>
						Fusce mattis lectus hendrerit, convallis ligula a, ornare risus. Mauris et sollicitudin mi. Aliquam lectus enim, hendrerit at facilisis faucibus, elementum non augue. Donec quis vulputate purus, eget congue mauris. Nullam lectus justo, suscipit id enim et, tincidunt ornare ligula.
					</blockquote>
					<p>Suspendisse sed nisl nibh. Donec eu elit eu urna semper luctus a ut tellus. Etiam eget ex a purus tempus dictum. Integer rhoncus est sem, vitae elementum mi semper et. Donec in laoreet lacus. Suspendisse dapibus congue sapien, a pretium sem vehicula aliquam. Etiam commodo tristique est ac dapibus. </p>
				</article>
			</div>
			<aside class="col-md-3 col-sm-4 col-xs-12 sidebar">
				<div class="block">
					<h3><span>menu</span></h3>
					<nav>
						<ul class="nav">
							<li><a href="page-simple.html">Simple page</a>
							</li>
							<li class="active"><a href="page-sidebar.html">Page with sidebar</a>
							</li>
							<li><a href="services.html">Services</a>
							</li>
							<li><a href="blog-index.html">Blog</a>
							</li>
						</ul>
					</nav>
				</div>
				<div class="block">
					<h3>About</h3>
					<a href="about-us.html"><img src="images/about.jpg" alt="" class="img-responsive">
					</a>
					<div class="text">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit.</p>
					</div>
				</div>
				<div class="block">
					<h3>Newsletter</h3>
					<form>
						<div class="animated-form-control form-group">
							<input type="email" name="email" class="form-control" placeholder="E-mail..." required="required" aria-required="true" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-block btn-custom">Subscribe Now</button>
						</div>
					</form>
				</div>
				<div class="block">
					<h3>Keep in touch</h3>
					<p class="social">
						<a href="#"><i class="fa fa-facebook social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-twitter social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-instagram social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-youtube social-icon-small" aria-hidden="true"></i></a>
					</p>
				</div>
			</aside>
		</div>
	</div>

	<footer class="page-footer">
		<div class="container">
			<div class="row">
				<div class="row-xs-12">
					<div class="divider"></div>
					<div class="text-center">
						<a href="index.html"><img src="images/logos/logo.png" alt="" class="logo">
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-9">
					<ul class="footer-links">
						<li><a href="#">Privacy Policy</a>
						</li>
						<li><a href="blog-index.html">Blog</a>
						</li>
						<li><a href="contact.html">Contact</a>
						</li>
					</ul>
				</div>
				<div class="col-sm-3">
					<p>© ZUPA 2016</p>
				</div>
			</div>
		</div>
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="javascript/script.js"></script>
</body>

</html>