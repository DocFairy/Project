<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>ZUPA - Responsive Website Template / Blog</title>
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
			<div class="col-lg-10 col-lg-offset-1 col-md-12">
				<article>
					<img src="images/blog-thumb-1.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">cabbage</a> <a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Lunch table</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">Jean Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-03-03">March 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-2.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Aenean tincidunt rhoncus metus</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">John Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-05-03">May 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-1.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">cabbage</a> <a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Lunch table</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">Jean Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-03-03">March 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-2.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Aenean tincidunt rhoncus metus</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">John Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-05-03">May 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-1.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">cabbage</a> <a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Lunch table</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">Jean Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-03-03">March 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-2.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Aenean tincidunt rhoncus metus</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">John Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-05-03">May 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
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
	<script src="javascript/animate-on-scroll.js"></script>
	<script src="javascript/script.js"></script>
</body>

</html>