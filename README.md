# DCI Architecture

An implementation of DCI Architecture in Kotlin.

## References

- [The DCI Architecture: A New Vision of Object-Oriented Programming](https://www.artima.com/articles/the-dci-architecture-a-new-vision-of-object-oriented-programming)
- [DCI Examples](http://fulloo.info/Examples/)

# How to execute

```
$ gradle run --args="SavingAccount Mike CheckingAccount Jane 3"
```

## Execution result 

```
-- Checking Account
{name=Jane, balance=100}
{name=Mike, balance=100}
-- Saving Account
{name=Jane, balance=10}
{name=Mike, balance=10}
-- Checking Account
{name=Jane, balance=103}
{name=Mike, balance=100}
-- Saving Account
{name=Jane, balance=10}
{name=Mike, balance=7}
```

# Arguments

```
resource_type_of_src name_of_src resource_type_of_dst name_of_dst amount
```

|  argument              |  description   |
|  --                    |  --            |
|  resource_type_of_src  |  移動元の種別  |
|  name_of_src           |  移動元の名前  |
|  resource_type_of_dst  |  移動先の種別  |
|  name_of_dst           |  移動先の名前  |
|  amount                |  移動させる量  |

## Type

### Resource type

- CheckingAccount
- SavingAccount

# Data

## CheckingAccountRepository

|  name  |  balance  |
|  --    |  --   |
|  Jane  |  100  |
|  Mike  |  100  |

## SavingAccountRepository

|  name  |  balance  |
|  --    |  --   |
|  Jane  |  10  |
|  Mike  |  10  |