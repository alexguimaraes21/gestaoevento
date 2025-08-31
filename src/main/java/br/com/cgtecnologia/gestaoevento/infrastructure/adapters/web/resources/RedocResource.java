package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.web.resources;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redoc")
public class RedocResource {

    private final ServletContext servletContext;

    public RedocResource(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @GetMapping
    public String redoc() {
        String contextPath = servletContext.getContextPath();
        String openApiSpecUrl = contextPath + "/v3/api-docs";

        return """
                <!DOCTYPE html>
                <html>
                  <head>
                    <title>Redoc</title>
                    <!-- needed for adaptive design -->
                    <meta charset="utf-8"/>
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,700|Roboto:300,400,700" rel="stylesheet">
                
                    <!--
                    Redoc doesn't change outer page styles
                    -->
                    <style>
                      body {
                        margin: 0;
                        padding: 0;
                      }
                    </style>
                  </head>
                  <body>
                    <redoc spec-url='%s'></redoc>
                    <script src="https://cdn.redoc.ly/redoc/latest/bundles/redoc.standalone.js"> </script>
                  </body>
                </html>
                """.formatted(openApiSpecUrl);
    }
}
