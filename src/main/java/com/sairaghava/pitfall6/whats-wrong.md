### Pitfall 6 - A technically valid but, unsatisfying, equals method

- After applying the Pitfall5 remedy, that is making the equals() more stricter,  both the symmetry and transitivty proeprty works good, but there is new problem whenever we create an anonymous inner class of a Point and does equals comparison it fails

> **Remedy/Fix: canEqual() method as the final solution**