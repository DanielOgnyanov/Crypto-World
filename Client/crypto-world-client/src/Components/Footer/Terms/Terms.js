import React from 'react';
import './Terms.css';

const Terms = () => {
  return (
    <div className="terms-container">
      <h1>Terms of Service</h1>
      <p>Last updated: June 19, 2025</p>

      <section>
        <h2>1. Acceptance of Terms</h2>
        <p>
          By accessing or using CryptoWorld, you agree to be bound by these Terms of Service and our Privacy Policy. If you do not agree, please do not use our services.
        </p>
      </section>

      <section>
        <h2>2. Use of Our Services</h2>
        <p>
          You must be at least 18 years old to use our platform. You are responsible for your account and all activities that occur under it.
        </p>
      </section>

      <section>
        <h2>3. User Conduct</h2>
        <p>
          You agree not to use the platform for any unlawful or prohibited activities, including spreading malware, abusing the API, or interfering with the service.
        </p>
      </section>

      <section>
        <h2>4. Intellectual Property</h2>
        <p>
          All content on CryptoWorld, including logos, design, and code, is the property of CryptoWorld and protected by copyright laws. You may not copy or redistribute without permission.
        </p>
      </section>

      <section>
        <h2>5. Termination</h2>
        <p>
          We reserve the right to suspend or terminate your account at our discretion, especially if these terms are violated.
        </p>
      </section>

      <section>
        <h2>6. Disclaimer</h2>
        <p>
          We provide our platform "as is" without warranties of any kind. We do not guarantee that the service will be uninterrupted or error-free.
        </p>
      </section>

      <section>
        <h2>7. Changes to Terms</h2>
        <p>
          We may update these terms from time to time. Continued use of the service after changes indicates your agreement to the new terms.
        </p>
      </section>

      <p>If you have any questions, contact us at support@cryptoworld.com.</p>
    </div>
  );
};

export default Terms;
