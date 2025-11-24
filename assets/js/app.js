function loadProducts() {
  fetch("http://localhost:8080/product/getAll")
    .then((res) => {
      if (!res.ok) throw new Error("Failed to fetch products");
      return res.json();
    })
    .then((data) => {
      console.log("Products loaded:", data);
      popularProductUi(data);
    })
    .catch((err) => {
      console.error(err);
      document.getElementById("product-container").innerHTML = 
        `<p class="text-center text-danger fs-4">Failed to load products. Is the server running?</p>`;
    });
}

loadProducts();

function popularProductUi(data) {
  const productContainer = document.getElementById("product-container");
  let html = "";

  data.forEach((product) => {
    
    let stockText = "";
    let stockClass = "";

    if (product.stock > 10) {
      stockText = `${product.stock} in stock`;
      stockClass = "text-success fw-bold";
    } else if (product.stock > 0) {
      stockText = `Only ${product.stock} left!`;
      stockClass = "text-warning fw-bold";
    } else {
      stockText = "Out of stock";
      stockClass = "text-danger";
    }

    
    html += `
      <div class="col">
        <div class="product-card">
          <img src="${product.image || 'https://via.placeholder.com/300x300?text=No+Image'}" 
               class="product-img" 
               alt="${product.name}" 
               onerror="this.src='https://via.placeholder.com/300x300?text=Image+Not+Found'">
          
          <div class="card-body">
            <h5 class="product-name">${product.name}</h5>
            <p class="product-category text-muted mb-2">${product.category || 'Uncategorized'}</p>
            <div class="product-price text-danger fs-4 fw-bold">$${Number(product.price).toFixed(2)}</div>
            <p class="stock-info ${stockClass} mt-2">${stockText}</p>
            <button class="btn btn-dark w-100 mt-3">Add to Cart</button>
          </div>
        </div>
      </div>
    `;
  });

  productContainer.innerHTML = html;
}