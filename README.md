
# Checkout System

This project implements a checkout system for a shop that sells apples and oranges. The system supports different discount strategies, including "Buy one, get one free" for apples and "3 for the price of 2" for oranges.

## Installation

1. **Clone the repository**:
    ```sh
    git clone git@github.com:gnaveenk83/checkout-system.git
    cd checkout-system
    ```

2. **Set up the project**:
    Ensure you have [sbt](https://www.scala-sbt.org/) installed. Then, run:
    ```sh
    sbt compile
    ```

3. **Run the tests**:
    ```sh
    sbt test
    ```

## Usage

### Shopping Cart

The `ShoppingCart` class allows you to add items and retrieve the list of items.

**Example**:
```scala
import com.shopping.model.{Apple, Orange}
import com.shopping.util.ShoppingCart

val cart = new ShoppingCart
cart.addItem(new Apple)
cart.addItem(new Orange)
val items = cart.getItems
```

### Checkout System

The `CheckoutSystem` class calculates the total cost of items in the cart, applying any provided discount strategies.

**Example**:
```scala
import com.shopping.model.{Apple, Orange}
import com.shopping.service.{CheckoutSystem, AppleDiscountStrategy, OrangeDiscountStrategy}

val cart = new ShoppingCart
cart.addItem(new Apple)
cart.addItem(new Apple)
cart.addItem(new Orange)
cart.addItem(new Apple)
val discountStrategies = Seq(new AppleDiscountStrategy, new OrangeDiscountStrategy)
val checkout = new CheckoutSystem(discountStrategies)
val totalCost = checkout.calculateTotalCost(cart.getItems)
println(s"Total cost: £$totalCost")
```

## Discount Strategies

- **NoDiscountStrategy**: No discounts are applied.
- **AppleDiscountStrategy**: "Buy one, get one free" for apples.
- **OrangeDiscountStrategy**: "3 for the price of 2" for oranges.
- **CompositeDiscountStrategy**: Combines multiple discount strategies.

### Tests

This project uses ScalaTest for unit testing. Tests are included for each component to ensure correctness.

To run tests:
```sh
sbt test
```

## Authors

- **Naveen** - *Checkout System* - [gnaveenk83](https://github.com/gnaveenk83)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
