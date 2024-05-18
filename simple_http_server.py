import http.server
import socketserver

PORT = 8000
DIRECTORY = "/shared"

class Handler(http.server.SimpleHTTPRequestHandler):
    def _init_(self, *args, **kwargs):
        super()._init_(*args, directory=DIRECTORY, **kwargs)

with socketserver.TCPServer(("", PORT), Handler) as httpd:
    print(f"Serving at port {PORT}")
    httpd.serve_forever()