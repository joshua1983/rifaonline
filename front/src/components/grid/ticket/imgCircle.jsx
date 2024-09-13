import React from 'react';

const ImageWithCircle = ({ imageSrc, circleText }) => {
  return (
    <div style={{ position: 'relative', width: '100%', height: '300px', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
      <img 
        src={imageSrc} 
        alt="Centered Image" 
        style={{ maxWidth: '100%', maxHeight: '100%', objectFit: 'contain' }}
      />
      <div style={{
        position: 'absolute',
        top: '8px',
        right: '10px',
        width: '90px',
        height: '90px',
        borderRadius: '50%',
        backgroundColor: 'pink',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        color: 'white',
        fontWeight: 'bold',
        fontSize: '1.5em',
        fontFamily: 'Poppins, sans-serif'
      }}>
        {circleText}
      </div>
    </div>
  );
};

export default ImageWithCircle;
