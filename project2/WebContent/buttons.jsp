<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>ZUPA - Responsive Website Template / Buttons</title>
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
			<div class="col-lg-8 col-lg-offset-2 col-md-12">
				<article class="content">
					<section>
						<h2>Buttons</h2>
						<!-- Standard button -->
						<p class="text-center">
							<button type="button" class="btn btn-custom">Custom</button>
							<button type="button" class="btn btn-default">Default</button>
							<button type="button" class="btn btn-primary">Primary</button>
							<button type="button" class="btn btn-success">Success</button>
						</p>
						<p class="text-center">
							<button type="button" class="btn btn-info">Info</button>
							<button type="button" class="btn btn-warning">Warning</button>
							<button type="button" class="btn btn-danger">Danger</button>
							<button type="button" class="btn btn-link">Link</button>
						</p>
					</section>
					<section>
						<h3>Sizes</h3>
						<p class="text-center">
							<button type="button" class="btn btn-primary btn-lg">Large button</button>
							<button type="button" class="btn btn-default btn-lg">Large button</button>
						</p>
						<p class="text-center">
							<button type="button" class="btn btn-primary">Default button</button>
							<button type="button" class="btn btn-default">Default button</button>
						</p>
						<p class="text-center">
							<button type="button" class="btn btn-primary btn-sm">Small button</button>
							<button type="button" class="btn btn-default btn-sm">Small button</button>
						</p>
						<p class="text-center">
							<button type="button" class="btn btn-primary btn-xs">Extra small button</button>
							<button type="button" class="btn btn-default btn-xs">Extra small button</button>
						</p>
					</section>
					<section>
						<h3>Block</h3>
						<button type="button" class="btn btn-primary btn-lg btn-block">Block level button</button>
						<button type="button" class="btn btn-default btn-lg btn-block">Block level button</button>
					</section>
					<section>
						<h3>Social</h3>
						<p class="text-center">
							<a href="#"><i class="fa fa-facebook social-icon" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-twitter social-icon" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-instagram social-icon" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-dribbble social-icon" aria-hidden="true"></i></a>
							<a href="#"><i class="fa fa-youtube social-icon" aria-hidden="true"></i></a>
						</p>
					</section>
					<section>
						<h3>Pagination</h3>
						<nav class="text-center">
							<ul class="pagination">
								<li>
									<a href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<li class="active"><a href="#">1</a>
								</li>
								<li><a href="#">2</a>
								</li>
								<li><a href="#">3</a>
								</li>
								<li class="disabled"><a href="#">4</a>
								</li>
								<li><a href="#">5</a>
								</li>
								<li>
									<a href="#" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</ul>
						</nav>
					</section>
				</article>

			</div>
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