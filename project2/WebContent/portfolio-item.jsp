<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>ZUPA - Responsive Website Template / Portfolio item</title>
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
		<div class="row portfolio-item">
			<div class="col-md-8">
				<div class="swiper-container gallery-top">
					<div class="swiper-wrapper">
						<img src="images/portfolio/item-1.jpg" alt="" class="swiper-slide">
						<img src="images/portfolio/item-2.jpg" alt="" class="swiper-slide">
						<img src="images/portfolio/item-3.jpg" alt="" class="swiper-slide">
						<img src="images/portfolio/item-4.jpg" alt="" class="swiper-slide">
					</div>
					<!-- Add Arrows -->
					<div class="swiper-button-next swiper-button-white"></div>
					<div class="swiper-button-prev swiper-button-white"></div>
				</div>
				<div class="swiper-container gallery-thumbs">
					<div class="swiper-wrapper">
						<div class="swiper-slide" style="background-image:url(images/portfolio/item-1.jpg)"></div>
						<div class="swiper-slide" style="background-image:url(images/portfolio/item-2.jpg)"></div>
						<div class="swiper-slide" style="background-image:url(images/portfolio/item-3.jpg)"></div>
						<div class="swiper-slide" style="background-image:url(images/portfolio/item-4.jpg)"></div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<article class="content">
					<h1>Portfolio Item</h1>
					<p class="text-justify">Lorem ipsum dolor sit amet, <strong>consectetur adipiscing elit.</strong> Vestibulum maximus nunc et velit semper, at pellentesque ex semper. Morbi enim massa, porta ut elementum ut, gravida interdum lacus. Etiam enim justo, semper sed scelerisque id, tristique at risus.</p>

					<p class="text-center social">
						<a href="#"><i class="fa fa-facebook social-icon" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-twitter social-icon" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-instagram social-icon" aria-hidden="true"></i></a>
					</p>
				</article>
			</div>
		</div>

		<div class="row content">
			<div class="col-sm-12 col-md-8">
				<h2>Portfolio item details</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In non imperdiet ante. Nam luctus nulla ac justo euismod bibendum. Maecenas vel libero dapibus, accumsan sem eu, viverra nisi. Nunc lectus justo, pulvinar vel libero ac, aliquam malesuada orci. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ut leo et arcu condimentum maximus. Nulla facilisi. </p>
				<h4>Ingredients</h4>
				<ul>
					<li>400 g dried linguine</li>
					<li>olive oil</li>
					<li>350 g tomato passata</li>
					<li>5 tablespoons baby capers</li>
					<li>1 lemon</li>
					<li>Parmesan cheese</li>
				</ul>
				<h4>Method</h4>
				<ol>
					<li>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In non imperdiet ante. Nam luctus nulla ac justo euismod bibendum. Maecenas vel libero dapibus, accumsan sem eu, viverra nisi.</li>
					<li>Nam iaculis sapien a dolor pellentesque, vitae tristique quam cursus. Aenean quis mauris accumsan purus aliquet lobortis. Sed diam ante, fermentum et fermentum id, consequat et odio. Praesent sed nibh tristique, fringilla elit volutpat, venenatis orci.</li>
					<li>Pellentesque vel pulvinar orci. Donec lacinia, mauris non egestas tempor, dolor velit gravida orci, in vestibulum urna arcu eget purus. Aliquam erat volutpat.</li>
				</ol>
			</div>
		</div>

		<div class="recent-works">
			<h3>Recent works</h3>
			<div class="portfolio grid-4">
				<figure>
					<img src="images/portfolio/1.jpg" alt="" />
					<figcaption>
						<h2>Portfolio Item</h2>
						<p>Dis-moi ce que tu manges, je te dirai ce que tu es</p>
						<a href="portfolio-item.html">View more</a>
					</figcaption>
				</figure>
				<figure>
					<img src="images/portfolio/2.jpg" alt="" />
					<figcaption>
						<h2>Portfolio Item</h2>
						<p>Dis-moi ce que tu manges, je te dirai ce que tu es</p>
						<a href="portfolio-item.html">View more</a>
					</figcaption>
				</figure>
				<figure>
					<img src="images/portfolio/3.jpg" alt="" />
					<figcaption>
						<h2>Portfolio Item</h2>
						<p>Dis-moi ce que tu manges, je te dirai ce que tu es</p>
						<a href="portfolio-item.html">View more</a>
					</figcaption>
				</figure>
				<figure>
					<img src="images/portfolio/4.jpg" alt="" />
					<figcaption>
						<h2>Portfolio Item</h2>
						<p>Dis-moi ce que tu manges, je te dirai ce que tu es</p>
						<a href="portfolio-item.html">View more</a>
					</figcaption>
				</figure>
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
	<script src="javascript/swiper.jquery.min.js"></script>
	<script src="javascript/modernizr-custom.js"></script>
	<script src="javascript/script.js"></script>
	<script>
	if (Modernizr.cssanimations) {
		var galleryTop = new Swiper('.gallery-top', {
			nextButton: '.swiper-button-next',
			prevButton: '.swiper-button-prev',
			spaceBetween: 10,
			effect: 'fade',
			loop: true,
			loopedSlides: 4
		});
		var galleryThumbs = new Swiper('.gallery-thumbs', {
			spaceBetween: 10,
			centeredSlides: true,
			slidesPerView: 'auto',
			touchRatio: 0.2,
			slideToClickedSlide: true,
			loop: true,
			loopedSlides: 4
		});
		galleryTop.params.control = galleryThumbs;
		galleryThumbs.params.control = galleryTop;
	} else {
		// IE9
		var galleryTop = new Swiper('.gallery-top', {
			nextButton: '.swiper-button-next',
			prevButton: '.swiper-button-prev'
		});
	}

	</script>
</body>

</html>